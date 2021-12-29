import { IUserplan } from '@/shared/model/userplan.model';

export interface IImplementationModel {
  id?: number;
  processInstance?: any | null;
  userplan?: IUserplan | null;
}

export class ImplementationModel implements IImplementationModel {
  constructor(public id?: number, public processInstance?: any | null, public userplan?: IUserplan | null) {}
}
