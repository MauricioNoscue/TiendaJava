// invoice-product.model.ts
export interface InvoiceProduct {
    invoicesId: number;
    date: string;  // Puede ser un string o Date dependiendo de cómo lo manejes
    productId: number;
    productName: string;
    productPrice: number;
    userName: string;
  }
  