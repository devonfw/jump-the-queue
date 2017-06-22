import oasp4fn from '@oasp/oasp4fn';
import dynamo from '@oasp/oasp4fn/dist/adapters/fn-dynamo';
import { HttpEvent, Context, Visitor } from '../../types';
import * as _ from 'lodash';

oasp4fn.setDB(dynamo);

oasp4fn.config({path: 'register'});
export async function register (event: HttpEvent, context: Context, callback: Function) {
    try {
        let visitor = <Visitor>event.body;
        let code = Math.random();
        await oasp4fn.insert('Queue', _.assign(visitor, { code: code })).promise();
        callback(null, { code: code, dateAndTime: new Date() });
    }
    catch(err){
        callback({message: 'Cannot register the visitor to the queue'});
    }
}