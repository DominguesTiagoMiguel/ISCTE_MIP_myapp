export interface IUserplan {
  id?: number;
  firstName?: string | null;
  lastName?: string | null;
  address?: string | null;
  postalCode?: string | null;
  city?: string | null;
  email?: string | null;
  password?: string | null;
  discountCode?: string | null;
  confirmationUser?: string | null;
  user?: string | null;
}

export class Userplan implements IUserplan {
  constructor(
    public id?: number,
    public firstName?: string | null,
    public lastName?: string | null,
    public address?: string | null,
    public postalCode?: string | null,
    public city?: string | null,
    public email?: string | null,
    public password?: string | null,
    public discountCode?: string | null,
    public confirmationUser?: string | null,
    public user?: string | null
  ) {}
}
