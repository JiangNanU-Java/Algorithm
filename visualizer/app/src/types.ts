export type Tag = { key: string; values: string[] };
export type InterviewItem = {
  path: string;
  package: string;
  name: string;
  category: string;
  type: 'algorithm' | 'theory' | 'scenario' | 'architecture' | 'middleware';
  tags: Tag[];
  visual?: { hasDemo?: boolean; entry?: string; stepsFormat?: string };
  content?: {
    description?: string;
    difficulty?: 'easy' | 'medium' | 'hard';
    company?: string;
    topics?: string[];
    solutions?: string[];
  };
};

export type AlgoItem = InterviewItem;