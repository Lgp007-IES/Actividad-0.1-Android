package com.example.simulacioncrudluis.Views

import android.util.Log
import com.example.simulacioncrudluis.Logic.Client
import com.example.simulacioncrudluis.Logic.interfaces.interfazCliente

class Dialog {
    private var listener: interfazCliente? = null

    fun setListener(listener: interfazCliente) {
        this.listener = listener
    }

    fun show(action: ActionType, currentClients: List<Client>) {
        Log.d("CRUD_Dialog", "Abriendo diálogo para acción: $action")

        when (action) {
            ActionType.INSERT -> {
                val newId = (currentClients.maxOfOrNull { it.id } ?: 0) + 1
                val newName = "Cliente Insertado"
                Log.d("CRUD_Dialog", "Capturando Inserción -> ID: $newId, Nombre: $newName")
                listener?.ClientAdd(newId, newName)
            }
            ActionType.UPDATE -> {
                if (currentClients.isNotEmpty()) {
                    val randomClient = currentClients.random()
                    val modifiedName = "${randomClient.name} (Editado)"
                    Log.d("CRUD_Dialog", "Capturando Edición -> ID: ${randomClient.id}, Nuevo Nombre: $modifiedName")
                    listener?.ClientUpdate(randomClient.id, modifiedName)
                } else {
                    Log.d("CRUD_Dialog", "No hay clientes para editar.")
                }
            }
            ActionType.DELETE -> {
                if (currentClients.isNotEmpty()) {
                    val randomClient = currentClients.random()
                    Log.d("CRUD_Dialog", "Capturando Eliminación -> ID: ${randomClient.id}")
                    listener?.ClientDel(randomClient.id)
                } else {
                    Log.d("CRUD_Dialog", "No hay clientes para eliminar.")
                }
            }
        }
    }

    enum class ActionType { INSERT, UPDATE, DELETE }
}