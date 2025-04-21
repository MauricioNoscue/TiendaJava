export interface proveedor{
    supplierID:number,
    address: String;
    supplierName: String;
    phone:string;
    email: String;
}

export interface idProveedor{
    supplierID: number;
}
export interface productoProveedor {
  productId: number;
  supplierId: number;
}