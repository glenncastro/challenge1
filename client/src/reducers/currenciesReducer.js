export default (state = [], action) => {
    switch(action.type) {
        case 'FETCH_CURRENCIES':
            return action.payload;
        default:
            return state;
    }
};