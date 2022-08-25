import {Address} from "./address";
import {Child} from "./child";

export interface Guardian {

    id: number;
    firstName: string;
    lastName: string;
    phoneNumber: string;
    address: Address
    children: Child[];

}

