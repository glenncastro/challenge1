import jsonPlaceholder from "../apis/jsonPlaceholder";

export const fetchCurrencies = () => async dispatch => {
    const response = await jsonPlaceholder.get('/currencies');
    dispatch({ type: 'FETCH_CURRENCIES', payload: response.data })
};

export const fetchCurrencyQuotes = currencyCode => async dispatch => {
    const response = await jsonPlaceholder.get(`/currencies/${currencyCode}`);
    dispatch({ type: 'FETCH_CURRENCY_QUOTES', payload: response.data.quotes })
};

export const fetchProfits = () => async dispatch => {
    const response = await jsonPlaceholder.get('/currencies/profits');
    dispatch({ type: 'FETCH_PROFITS', payload: response.data })
};
