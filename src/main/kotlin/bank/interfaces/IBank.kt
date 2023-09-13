package bank.interfaces

import wallet.interfaces.IWallet

interface IBank {
    fun sendFunds(source: IWallet, destination: IWallet, amount: Double) : Unit
}