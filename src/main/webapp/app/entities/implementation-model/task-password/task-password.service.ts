import axios from 'axios';
import { TaskPasswordContext } from './task-password.model';

const baseApiUrl = 'api/implementation-model/task-password';

export default class TaskPasswordService {
  public loadContext(taskId: number): Promise<TaskPasswordContext> {
    return new Promise<TaskPasswordContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskPasswordContext> {
    return new Promise<TaskPasswordContext>((resolve, reject) => {
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

  public complete(taskPasswordContext: TaskPasswordContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskPasswordContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
