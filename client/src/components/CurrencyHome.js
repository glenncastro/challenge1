import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import CurrencyCard from './CurrencyCard';

class CurrencyHome extends Component {

    render() {
        return (
            <div className="ui container">
                <h1 className="ui header">
                    Welcome to Cryptocurrencies
                </h1>
                <div className="ui segments">
                    <div className="ui stackable three column centered grid">
                        <div className="eight wide tablet four wide computer column">
                            <Link to="/currencies/btc">
                                <CurrencyCard code="btc"/>
                            </Link>
                        </div>
                        <div className="eight wide tablet four wide computer column">
                            <Link to="/currencies/eth">
                                <CurrencyCard code="eth"/>
                            </Link>
                        </div>
                        <div className="eight wide tablet four wide computer column">
                            <Link to="/currencies/ltc">
                                <CurrencyCard code="ltc"/>
                            </Link>
                        </div>
                    </div>
                    <div className="ui center aligned segment">
                        <button className="ui button">
                            <Link to="/profits">Show Maximum Profits</Link>
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

export default CurrencyHome;