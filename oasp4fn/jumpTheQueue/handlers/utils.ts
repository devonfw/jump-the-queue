import * as _ from 'lodash';
import { Visitor } from './types';

const ALPHABET = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';

export let getRandomCode = (len: number) => {
	if (!Number.isFinite(len) || len < 1) {
		throw new TypeError('Invalid code lenght');
	}

    let str = '';
    while(len > 0) {
        str += ALPHABET[_.random(Number.MAX_SAFE_INTEGER) % ALPHABET.length];
        --len;
    }

	return str;
};

export let validateVisitor = (visitor: Visitor) => {
	let ok = true;

    _.some(visitor, (value, key) => {
        switch (key) {
            case 'phone':
                ok = /(\d+\s)+\d+|\d+/.test(value);
                break;
            case 'email':
                ok = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
                break;
        }
        return !ok;
    })

	return ok;
};

export let isVisitor = (object: any): object is Visitor => {
    return 'name' in object && 'phone' in object && 'email' in object;
} 