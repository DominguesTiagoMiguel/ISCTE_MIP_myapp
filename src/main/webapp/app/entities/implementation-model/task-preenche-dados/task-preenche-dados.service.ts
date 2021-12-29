import axios from 'axios';
import { TaskPreencheDadosContext } from './task-preenche-dados.model';

const baseApiUrl = 'api/implementation-model/task-preenche-dados';

export default class TaskPreencheDadosService {
  public loadContext(taskId: number): Promise<TaskPreencheDadosContext> {
    return new Promise<TaskPreencheDadosContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskPreencheDadosContext> {
    return new Promise<TaskPreencheDadosContext>((resolve, reject) => {
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

  public complete(taskPreencheDadosContext: TaskPreencheDadosContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskPreencheDadosContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
