import oasp4fn from '@oasp/oasp4fn';
import dynamo from '@oasp/oasp4fn/dist/adapters/fn-dynamo';
import { HttpEvent, Context } from '../../types';

oasp4fn.setDB(dynamo, {endpoint: 'https://dynamodb.us-west-2.amazonaws.com'});

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
        callback({message: 'Cannot get the queue'});
    }
}