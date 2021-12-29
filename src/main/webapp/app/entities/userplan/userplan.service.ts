import axios from 'axios';

import { IUserplan } from '@/shared/model/userplan.model';

const baseApiUrl = 'api/userplans';

export default class UserplanService {
  public find(id: number): Promise<IUserplan> {
    return new Promise<IUserplan>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
