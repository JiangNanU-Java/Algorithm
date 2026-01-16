import { useEffect, useMemo, useState } from "react";
import { loadAlgorithms } from "./api";
import type { AlgoItem } from "./types";
import "./index.css";

type Filter = { q: string; category: string; source: string; type: string };

function AlgoCard({ item, onOpen }: { item: AlgoItem; onOpen: (a: AlgoItem) => void }) {
  const source = item.tags?.find(t => t.key === "source")?.values?.join(", ");
  return (
    <div className="glass p-4 hover:scale-[1.01] hover:shadow-lg transition cursor-pointer" onClick={() => onOpen(item)}>
      <div className="text-sm text-slate-300">{item.category}</div>
      <div className="text-xl font-semibold">{item.name || item.path.split("/").pop()?.replace(".java","")}</div>
      {source && <div className="mt-1 text-xs text-slate-400">source: {source}</div>}
      <div className="mt-2">
        <button className="px-2 py-1 text-xs rounded bg-blue-600 hover:bg-blue-500">可视化演示</button>
      </div>
    </div>
  );
}

function DetailRow({label, value}:{label:string; value: string | undefined}) {
  if (!value) return null;
  return (
    <div className="flex gap-2 text-sm">
      <div className="text-slate-400 min-w-14">{label}：</div>
      <div className="text-slate-200 break-all">{value}</div>
    </div>
  );
}

export default function App() {
  const [list, setList] = useState<AlgoItem[]>([]);
  const [filter, setFilter] = useState<Filter>({ q: "", category: "全部", source: "全部", type: "全部" });
  const [current, setCurrent] = useState<AlgoItem | null>(null);

  useEffect(() => { loadAlgorithms().then(setList).catch(() => setList([])); }, []);

  const categories = useMemo(() => ["全部", ...Array.from(new Set(list.map(x => x.category).filter(Boolean)))], [list]);
  const sources = useMemo(() => {
    const all = new Set<string>();
    list.forEach(x => x.tags?.filter(t => t.key === "source").forEach(t => t.values?.forEach(v => all.add(v))));
    return ["全部", ...Array.from(all)];
  }, [list]);
  const types = useMemo(() => ["全部", "algorithm", "theory", "scenario", "architecture", "middleware"], [list]);

  const filtered = useMemo(() => {
    const q = filter.q.trim().toLowerCase();
    return list.filter(x => {
      const okCat = filter.category === "全部" || x.category === filter.category;
      const okSrc = filter.source === "全部" || x.tags?.some(t => t.key === "source" && t.values?.includes(filter.source));
      const okType = filter.type === "全部" || x.type === filter.type;
      const okQ = !q || [x.name, x.package, x.path].some(f => (f || "").toLowerCase().includes(q));
      return okCat && okSrc && okType && okQ;
    });
  }, [list, filter]);

  const currentSource = current?.tags?.find(t => t.key === "source")?.values?.join(", ");
  const hasDemo = current?.visual?.hasDemo ? "是" : "否";
  const visualEntry = current?.visual?.entry || "";
  const difficulty = current?.content?.difficulty;
  const company = current?.content?.company;
  const topics = current?.content?.topics?.join(", ");
  const description = current?.content?.description;

  return (
    <div className="min-h-screen p-6 md:p-10">
      <header className="flex flex-col md:flex-row gap-3 md:items-center md:justify-between mb-6">
        <h1 className="text-2xl md:text-3xl font-bold">算法与面试复习可视化平台</h1>
        <div className="flex flex-col md:flex-row gap-2">
          <input className="glass px-3 py-2 outline-none" placeholder="搜索名称/包/路径"
                 value={filter.q} onChange={e => setFilter({ ...filter, q: e.target.value })}/>
          <select className="glass px-3 py-2" value={filter.type}
                  onChange={e => setFilter({ ...filter, type: e.target.value })}>
            {types.map(t => <option key={t} value={t}>{t === "全部" ? t : t + "题"}</option>)}
          </select>
          <select className="glass px-3 py-2" value={filter.category}
                  onChange={e => setFilter({ ...filter, category: e.target.value })}>
            {categories.map(c => <option key={c} value={c}>{c}</option>)}
          </select>
          <select className="glass px-3 py-2" value={filter.source}
                  onChange={e => setFilter({ ...filter, source: e.target.value })}>
            {sources.map(s => <option key={s} value={s}>{s}</option>)}
          </select>
        </div>
      </header>

      <main className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {filtered.length === 0 ? (
          <div className="col-span-full text-center text-slate-400 py-8">
            {list.length === 0 ? "正在加载算法数据..." : "未找到匹配的算法"}
          </div>
        ) : (
          filtered.map(item => <AlgoCard key={item.path} item={item} onOpen={setCurrent} />)
        )}
      </main>

      {current && (
        <div className="fixed inset-0 bg-black/50 flex items-center justify-center" onClick={() => setCurrent(null)}>
          <div className="glass max-w-2xl w-[90%] p-4" onClick={e => e.stopPropagation()}>
            <div className="flex items-center justify-between">
              <div className="text-xl font-semibold">{current.name || current.path}</div>
              <button className="text-slate-300" onClick={() => setCurrent(null)}>关闭</button>
            </div>

            <div className="mt-3 space-y-2">
              <DetailRow label="包" value={current.package} />
              <DetailRow label="分类" value={current.category} />
              <DetailRow label="类型" value={current.type} />
              <DetailRow label="来源" value={currentSource} />
              <DetailRow label="难度" value={difficulty} />
              <DetailRow label="公司" value={company} />
              <DetailRow label="话题" value={topics} />
              <DetailRow label="路径" value={current.path} />
              <DetailRow label="可视化" value={`是否有演示：${hasDemo}${visualEntry ? `，入口：${visualEntry}` : ""}`} />
              {description && (
                <div className="mt-3">
                  <div className="text-sm text-slate-400 mb-1">描述：</div>
                  <div className="text-sm text-slate-200 bg-slate-800/50 p-2 rounded">{description}</div>
                </div>
              )}
            </div>

            <div className="mt-4">
              <div className="text-sm mb-1">可视化演示（占位）：</div>
              <div className="glass h-48 flex items-center justify-center text-slate-400">
                未来在这里渲染步骤动画（播放/暂停/步进/速度）
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}