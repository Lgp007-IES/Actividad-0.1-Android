package com.example.simulacioncrudluis.Logic.interfaces

interface interfazCliente {
    fun ClientAdd ( id: Int, name: String )
    fun ClientDel ( id: Int)
    fun ClientUpdate ( id: Int, name: String)
}