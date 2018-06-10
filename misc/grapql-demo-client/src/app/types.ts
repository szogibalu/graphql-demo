export type Book = {
  name: string;
  author: Author;
}

export type Author = {
  name: string;
}

export type Query = {
  books: Book[];
}
