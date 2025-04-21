export interface userCreate{
    userId:number,
    userName: string,
    password:string,
    person:{
        personId: number
    }
}

export interface user{
    userId:number,
    userName: string,
    password:string,
    person:{
        personId: number
    }
}

export interface peronid{
    person_id: number
}

export interface login{
    username: string,
    password: string
}