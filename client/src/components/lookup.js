export const lookup = (code) => {
    switch(code) {
        case 'btc':
            return 'Bitcoin';
        case 'eth':
            return 'Etherium';
        case 'ltc':
            return 'Litecoin';
        default:
            return null;
    }
};