# 算法迁移脚本
$migrationPlan = Get-Content "visualizer/meta/migration-plan.json" | ConvertFrom-Json

foreach ($item in $migrationPlan) {
    $oldPath = "java/src/" + $item.oldPath
    $newPath = $item.newPath
    $oldPackage = $item.oldPackage
    $newPackage = $item.newPackage

    if (Test-Path $oldPath) {
        # 创建新目录
        $newDir = Split-Path $newPath -Parent
        if (!(Test-Path $newDir)) {
            New-Item -ItemType Directory -Path $newDir -Force | Out-Null
        }

        # 移动文件
        Move-Item $oldPath $newPath -Force

        # 更新package声明
        if ($oldPackage -and $newPackage -and $oldPackage -ne $newPackage) {
            $content = Get-Content $newPath -Raw
            $newContent = $content -replace "package $oldPackage;", "package $newPackage;"
            Set-Content $newPath $newContent
        }

        Write-Host "Migrated: $($item.oldPath) -> $($item.newPath)"
    } else {
        Write-Host "File not found: $oldPath"
    }
}

# 清理空的旧目录
Write-Host "Cleaning up empty directories..."
Get-ChildItem "java/src" -Directory -Recurse | Where-Object { (Get-ChildItem $_.FullName -Recurse | Measure-Object).Count -eq 0 } | Remove-Item -Force
