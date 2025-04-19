export interface PersonCreation {
  firstName: string;
  lastName: string;
  documentType: string;
  document: string;
  dateBorn: Date;
  phoneNumber: string;
  eps: string;
  genero: string;
}

export interface Person {
  id: number;
  firstName: string;
  lastName: string;
  documentType: string;
  document: string;
  dateBorn: Date;
  phoneNumber: string;
  eps: string;
  genero: string;
  relatedPerson: boolean;
  isDeleted: boolean;
}
