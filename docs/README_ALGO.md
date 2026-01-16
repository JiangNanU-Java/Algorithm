# 算法可视化平台与 Java 目录重构规范

本规范用于指导 java/src 下算法代码的统一命名与目录组织，并为可视化平台提供一致的数据来源。

## 1. 目标
- 提升检索与学习效率：统一分类、命名、示例与测试。
- 支撑可视化前端：通过 algorithms.json 元数据（可自动/半自动生成）。
- 可迭代扩展：支持后续添加新算法与可视化演示。

## 2. 顶层目录结构（建议）
```
java/
  src/
    algo/
      sorting/
      searching/
      graph/
      tree/
      string/
      dp/
      greedy/
      backtrack/
      math/
      dsu/
      heap/
      queue_stack/
      two_pointers/
      ds/
        list/
        array/
        hash/
        set/
        map/
    legacy/   # 迁移完成前的历史包临时放置（可选）
test/
  java/       # 与 src 同路径包结构
visualizer/
  meta/
    algorithms.json  # 扫描产物与手工补充
  README_VIS.md      # 可视化平台说明（后续补充）
docs/
  README_ALGO.md     # 本文件
```

说明：
- 新包统一前缀：`algo`。
- 一级类目对应中文分类：sorting(排序)、searching(搜索)、graph(图)、tree(树)、string(字符串)、dp(动态规划)、greedy(贪心)、backtrack(回溯)、math(数学/数论)、dsu(并查集)、heap(堆/优先队列)、queue_stack(队列与栈)、two_pointers(双指针/滑动窗口)、ds(数据结构基础)。
- 历史来源（ali/bytedance/tencent/pat/xiecheng/alimock）不作为目录，仅作为 tags.source 记录。

## 3. 包命名规范
- 统一前缀：`algo.<category>[.<topic>]`
  - 例：`algo.sorting.quicksort`、`algo.dp.knapsack`、`algo.tree.trie`、`algo.ds.list`
- Topic 规则：全小写、用明确英文词根，不使用缩写（dp 除外，沿用行业约定）。
- 迁移时尽量保持类职责单一：一个类实现一种核心算法或其一个变体。

## 4. 类命名规范
- 大驼峰 + 语义明确 + 版本/变体后缀（可选）：
  - `QuickSort` / `QuickSortV1` / `QuickSortLomuto` / `BinarySearchIter` / `BinarySearchRec`
  - 树/图等结构：`Trie`, `AVLTree`, `RBTree`, `Dijkstra`, `Kruskal`
- 工具/结构体命名：`MinHeap`, `UnionFind`, `DisjointSet`, `ListNode`, `TreeNode`
- 内部可视化步骤产出辅助类：`AlgoStep`, `AlgoState`（位于可视化模块或同包内的 internal 子包）

## 5. 测试与示例数据
- 测试目录：`test/java` 下与 src 包路径一致：
  - 例：`test/java/algo/sorting/QuickSortTest.java`
- 示例数据：若有输入样例，放置在 `java/resources/algo/<category>/<topic>/` 下；或在测试中内联小样例。

## 6. 可视化元数据 schema（前端约定）
algorithms.json 单项结构（建议）：
```json
{
  "path": "java/src/algo/sorting/QuickSort.java",
  "package": "algo.sorting",
  "name": "QuickSort",
  "category": "排序",
  "tags": [
    { "key": "source", "values": ["bytedance"] },
    { "key": "topic", "values": ["quicksort"] },
    { "key": "difficulty", "values": ["easy|medium|hard"] }
  ],
  "visual": {
    "hasDemo": true,
    "entry": "QuickSort#visualize", 
    "stepsFormat": "ArrayStepV1" 
  }
}
```
- 前期仅保证必需字段：path/package/name/category/tags。
- visual 区域用于标记该算法是否有可视化演示，以及入口函数签名与步骤数据格式名。

步骤数据建议格式（以排序为例）：
```json
{
  "type": "ArrayStepV1",
  "array": [5,2,3,1],
  "highlight": [1,3],
  "swap": [1,3],
  "i": 1,
  "j": 3,
  "pivot": 2,
  "note": "swap a[1] and a[3]"
}
```

## 7. 迁移映射规则
- 原包 → 新包的确定方式：
  1) 优先使用文件路径与类名关键词匹配（如 quick/sort → `algo.sorting`；binary/search → `algo.searching`）。
  2) 若有明确结构类型（`tree`, `graph`, `trie`, `union` 等）则归入对应一级类目或 ds 基础结构。
  3) 无法判断则暂置 `algo.misc`（待人工确认）。
- 来源标签：从原包名提取 `ali/alimock/bytedance/tencent/pat/xiecheng`，写入 `tags.source`。
- 迁移时保留版权头与作者注释；在类头部添加 `@MovedFrom("old.package.ClassName")` 或 Javadoc 说明。
- 允许在迁移阶段维持旧包并新增新包并存一段时间；最终统一到 `algo.*` 后移除旧包（CI或构建检查可禁用 legacy）。

## 8. 迁移示例
原路径：
```
java/src/adt/stack/Stack.java  (package adt.stack)
```
迁移后：
```
java/src/algo/queue_stack/Stack.java  (package algo.queue_stack)
```
algorithms.json 变更（示意）：
- category: 队列与栈
- tags 增加 `{"key":"topic","values":["stack"]}`

## 9. 自动化支持
- 使用 PowerShell/Java 小工具扫描并更新 algorithms.json：
  - 若缺失 package/name，则从路径推断并填充。
  - 允许在 `visualizer/meta/overrides.json` 中手工覆盖字段（高优先级）。
- 迁移脚本先生成 “迁移计划预览” 与 “冲突报告”，经确认后再执行实际移动。

## 10. 提交流程建议
- 新增算法：同时提交实现、测试、algorithms.json 增量或 overrides.json。
- 新增可视化：在 visual 字段标注入口与步骤格式；前端会自动发现并显示“可视化演示”按钮。

## 11. 未决与后续
- 分类边界细化（如字符串子类：匹配/哈希/字典树）。
- 可视化步骤格式的标准库定义与示例集合。
- 将来可接入后端服务或自动从仓库构建清单。

如需调整命名或目录，请在合并前注明，我们将同步更新本规范与扫描脚本。