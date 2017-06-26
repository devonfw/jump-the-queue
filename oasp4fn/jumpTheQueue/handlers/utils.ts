import * as _ from 'lodash';

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