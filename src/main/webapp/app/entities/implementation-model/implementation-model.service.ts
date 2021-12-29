import axios from 'axios';

import { IImplementationModel } from '@/shared/model/implementation-model.model';

const baseApiUrl = 'api/implementation-models';

export default class ImplementationModelService {
  public find(id: number): Promise<IImplementationModel> {
    return new Promise<IImplementationModel>((resolve, reject) => {
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

  public create(entity: IImplementationModel): Promise<IImplementationModel> {
    return new Promise<IImplementationModel>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
