import oasp4fn from '@oasp/oasp4fn';
import dynamo from '@oasp/oasp4fn/dist/adapters/fn-dynamo';
import { HttpEvent, Context, Visitor } from '../../types';
import * as _ from 'lodash';
import { getRandomCode, validateVisitor, isVisitor } from '../../utils';

oasp4fn.setDB(dynamo, {endpoint: 'https://dynamodb.us-west-2.amazonaws.com'});

oasp4fn.config({path: 'register'});
export async function register (event: HttpEvent, context: Context, callback: Function) {
    try {
        let visitor = event.body;

        if(!isVisitor(visitor) || !validateVisitor(visitor))
            throw new Error();

        let date = new Date();
        date.setDate(date.getDate() + 1);
        
        let code: string | undefined;
        while(!code) {
            let aux = getRandomCode(3);
            let res = await oasp4fn.table('Queue', aux).promise();
            if(!res)
                code = aux;
        }

        let result = { code: code, dateAndTime: Date.parse(date.toDateString())};
        await oasp4fn.insert('Queue', _.assign(visitor, result)).promise();
        callback(null, result);
    }
    catch(err){
        callback(new Error('[500] Cannot register the visitor to the queue'));
    }
} 