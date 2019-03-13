import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import moment from 'moment';
import { fetchProfits } from '../actions';

class CurrencyProfits extends Component {

    componentDidMount() {
        this.props.fetchProfits();
    }

    formatAmount(amount) {
        return new Intl.NumberFormat('en-AU', { style: 'currency', currency: 'AUD' }).format(amount);
    }

    formatTime(time) {
        return moment(time,'HHmm').format('hh:mm A');
    }
    
    renderProfitsTable() {
        
        const profitsTable = this.props.profits.map((anObjectMapped, index) => {
            let btcBuyPrice = JSON.stringify(anObjectMapped.BTC.buyPrice);
            let btcSellPrice = JSON.stringify(anObjectMapped.BTC.sellPrice);
            let btcBuyTime = JSON.stringify(anObjectMapped.BTC.buyTime);
            let btcSellTime = JSON.stringify(anObjectMapped.BTC.sellTime);
            let btcProfit = JSON.stringify(anObjectMapped.BTC.profit);

            let ethBuyPrice = JSON.stringify(anObjectMapped.ETH.buyPrice);
            let ethSellPrice = JSON.stringify(anObjectMapped.ETH.sellPrice);
            let ethBuyTime = JSON.stringify(anObjectMapped.ETH.buyTime);
            let ethSellTime = JSON.stringify(anObjectMapped.ETH.sellTime);
            let ethProfit = JSON.stringify(anObjectMapped.ETH.profit);

            let ltcBuyPrice = JSON.stringify(anObjectMapped.LTC.buyPrice);
            let ltcSellPrice = JSON.stringify(anObjectMapped.LTC.sellPrice);
            let ltcBuyTime = JSON.stringify(anObjectMapped.LTC.buyTime);
            let ltcSellTime = JSON.stringify(anObjectMapped.LTC.sellTime);
            let ltcProfit = JSON.stringify(anObjectMapped.LTC.profit);

            return (
                <table className="ui celled table">
                    <thead>
                        <tr>
                            <th colSpan="2">BTC</th>
                            <th colSpan="2">ETH</th>
                            <th colSpan="2">LTC</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Buy</td>
                            <td>Sell</td>
                            <td>Buy</td>
                            <td>Sell</td>
                            <td>Buy</td>
                            <td>Sell</td>
                        </tr>
                        <tr>
                            <td>{this.formatAmount(btcBuyPrice)}</td>
                            <td>{this.formatAmount(btcSellPrice)}</td>
                            <td>{this.formatAmount(ethBuyPrice)}</td>
                            <td>{this.formatAmount(ethSellPrice)}</td>
                            <td>{this.formatAmount(ltcBuyPrice)}</td>
                            <td>{this.formatAmount(ltcSellPrice)}</td>
                        </tr>
                        <tr>
                            <td>{this.formatTime(btcBuyTime)}</td>
                            <td>{this.formatTime(btcSellTime)}</td>
                            <td>{this.formatTime(ethBuyTime)}</td>
                            <td>{this.formatTime(ethSellTime)}</td>
                            <td>{this.formatTime(ltcBuyTime)}</td>
                            <td>{this.formatTime(ltcSellTime)}</td>
                        </tr>
                        <tr>
                            <td>Profit</td>
                            <td>{this.formatAmount(btcProfit)}</td>
                            <td>Profit</td>
                            <td>{this.formatAmount(ethProfit)}</td>
                            <td>Profit</td>
                            <td>{this.formatAmount(ltcProfit)}</td>
                        </tr>
                    </tbody>
                </table>
            )
        });
        return profitsTable;
    }

    render() {
        return (
            <div className="ui container">
                <div className="ui segments">
                    <div className="ui segment">
                        <h1>Maximum Profit</h1>
                    </div>
                    <div className="ui segment">
                        {this.renderProfitsTable()}
                    </div>
                    <div className="ui center aligned segment">
                        <button class="ui button">
                            <Link to="/">Home</Link>
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        profits: state.profits
    };
};

export default connect(mapStateToProps, { fetchProfits })(CurrencyProfits);