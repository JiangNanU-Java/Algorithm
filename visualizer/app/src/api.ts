import type { AlgoItem } from "./types";

export async function loadAlgorithms(): Promise<AlgoItem[]> {
  const results: AlgoItem[] = [];

  // 加载原有算法数据
  try {
    const res = await fetch("/algorithms.json", { cache: "no-store" });
    if (res.ok) results.push(...((await res.json()) as AlgoItem[]));
  } catch {}
  try {
    const res2 = await fetch("../meta/algorithms.json", { cache: "no-store" });
    if (res2.ok) results.push(...((await res2.json()) as AlgoItem[]));
  } catch {}

  // 加载新的面试内容
  try {
    const res3 = await fetch("../meta/interview-content.json", { cache: "no-store" });
    if (res3.ok) results.push(...((await res3.json()) as AlgoItem[]));
  } catch {}

  return results;
}