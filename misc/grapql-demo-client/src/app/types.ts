export type Book = {
  name: string;
  author: Author;
  publicationYear: number
}

export type Author = {
  name: string;
}

export type Query = {
  listBooks: Book[];
}
