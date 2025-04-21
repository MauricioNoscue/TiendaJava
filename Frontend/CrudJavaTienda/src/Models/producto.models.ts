export interface productoSelect {
    productId: number;
    productName: string;
    description: string;
    productPrice: number;
    categoryId?: number; // opcional si estás usando category completo
    category?: {
      categoryId: number;
      name: string;
    };
    productSupplier?: any[]; // puedes tiparlo mejor si sabes cómo vienen los suppliers
  }
  

export interface productoEditar{
    productId: number;
    productName: string;
    description: string;
    productPrice: number;
    categoryId: number
}

export interface productCrear{
    productName: string;
    description: string;
    productPrice: number;
    categoryId: number
}