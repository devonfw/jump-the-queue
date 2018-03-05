import oasp4fn from '@oasp/oasp4fn';
import dynamo from '@oasp/oasp4fn/dist/adapters/fn-dynamo';
import { HttpEvent, Context } from '../../types';

oasp4fn.setDB(dynamo);

oasp4fn.config({path: 'search'});
export async function search (event: HttpEvent, context: Context, callback: Function) {
    try {
        let visitor = event.body;
        let res = await oasp4fn.table('Queue')
                        .filter(visitor)
                        .promise();
        callback(null, res);
    }
    catch(err){
        callback(new Error('[500] Cannot get the queue'));
    }
}