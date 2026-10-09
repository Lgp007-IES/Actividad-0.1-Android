package com.example.simulacioncrudluis.Logic

import android.util.Log
import com.example.simulacioncrudluis.Data.Repositorio

class Controller {
    private val clientList: MutableList<Client> = mutableListOf()

    init {
        clientList.addAll(Repositorio.initialClients)
        Log.d("CRUD_Controller", "Datos inicializados: $clientList")
    }

    fun controllerAdd(id: Int, name: String,telefono:String) {
        clientList.add(Client(id, name,telefono))
    }

    fun controllerDelete(id: Int) : Boolean {
        val client = clientList.find { it.id == id }
        if (client != null) {
            clientList.remove(client)
            return true
        }
        return false
    }

    fun controllerUpdate(id: Int, name: String,telefono: String) {
        val client = clientList.find { it.id == id }
        if (client != null) {
            client.name = name
            client.telf = telefono
            Log.d("CRUD_Controller", "Actualizado ID: $id con nombre: $name - Tel: $telefono. Lista actual: $clientList")
        }
    }

    fun getClients(): List<Client> = clientList.toList()
}