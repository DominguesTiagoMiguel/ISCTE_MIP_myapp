import axios from 'axios';
import { TaskInsertDiscountContext } from './task-insert-discount.model';

const baseApiUrl = 'api/implementation-model/task-insert-discount';

export default class TaskInsertDiscountService {
  public loadContext(taskId: number): Promise<TaskInsertDiscountContext> {
    return new Promise<TaskInsertDiscountContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskInsertDiscountContext> {
    return new Promise<TaskInsertDiscountContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskInsertDiscountContext: TaskInsertDiscountContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskInsertDiscountContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
