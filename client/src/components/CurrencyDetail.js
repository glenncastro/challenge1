import React, { Component } from 'react';
import moment from 'moment';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import { fetchCurrencyQuotes } from '../actions';
import { lookup } from './lookup';

class CurrencyDetail extends Component {

    componentDidMount() {
        this.props.fetchCurrencyQuotes(this.props.match.params.currency);
    }

    //create the Quotes Table structure
    renderQuotesTable() {
        return (
            <table className="ui unstackable table">
                <thead>
                    <tr>
                        <th>Time</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {this.composeQuotes()}
                </tbody>
            </table>
        );
    }

    //create the quotes row
    composeQuotes() {
        const quotes = this.props.quotes.map((element) => {
            let quote = JSON.parse(element);
            
            return (
                <tr key={quote.time}>
                    <td>{moment(quote.time,'HHmm').format('hh:mm A')}</td>
                    <td>{quote.price}</td>
                </tr>
            );
        });
        return quotes;
    }

    renderHeader() {
        const currencyCode = this.props.match.params.currency;
    
        return (
            <h2 className="ui header">
                <img src={`../images/${currencyCode}-icon.svg`} 
                    alt={`${lookup(currencyCode)} icon`} />
                <div className="content">
                    {lookup(currencyCode)}
                    <div className="sub header">List of Prices</div>
                </div>
            </h2>
        );
    }

    render() {
        return (
            <div className="ui container">
                <div className="ui segments">
                    <div className="ui segment">{this.renderHeader()}</div>
                    <div className="ui segment">{this.renderQuotesTable()}</div>
                    <div className="ui center aligned segment">
                        <button className="ui button">
                            <Link to="/">Home</Link>
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

const mapStateToProps = ( state ) => {
    
    return {
        quotes: state.quotes
    };
}

export default connect(mapStateToProps, { fetchCurrencyQuotes })(CurrencyDetail);