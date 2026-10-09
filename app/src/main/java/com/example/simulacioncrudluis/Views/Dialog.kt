package com.example.simulacioncrudluis.Views

import android.util.Log
import com.example.simulacioncrudluis.Logic.Client

class Dialog {
    private var onAddAction: ((Int, String,String) -> Unit)? = null
    private var onDeleteAction: ((Int) -> Unit)? = null
    private var onUpdateAction: ((Int, String,String) -> Unit)? = null

    fun setActions(
        onAdd: (Int, String,String) -> Unit,
        onDelete: (Int) -> Unit,
        onUpdate: (Int, String,String) -> Unit
    ) {
        this.onAddAction = onAdd
        this.onDeleteAction = onDelete
        this.onUpdateAction = onUpdate
    }
    fun show(action: ActionType, currentClients: List<Client>) {
        Log.d("CRUD_Dialog", "Abriendo diálogo para acción: $action")

        when (action) {
            ActionType.INSERT -> {
                val newId = (currentClients.maxOfOrNull { it.id } ?: 0) + 1
                val newName = "Cliente Lambda"
                val newPhone = "600999888"
                Log.d("CRUD_Dialog", "Capturando Inserción -> ID: $newId, Nombre: $newName - Telefono: $newPhone")
                onAddAction?.invoke(newId, newName,newPhone) // Ejecuta la lambda
            }
            ActionType.UPDATE -> {
                if (currentClients.isNotEmpty()) {
                    val randomClient = currentClients.random()
                    val modifiedName = "${randomClient.name} (Editado)"
                    val modifiedPhone = "611222333"
                    Log.d("CRUD_Dialog", "Capturando Edición -> ID: ${randomClient.id}, Nuevo Nombre: $modifiedName, Nuevo Telf: $modifiedPhone")
                    onUpdateAction?.invoke(randomClient.id, modifiedName,modifiedPhone)
                } else {
                    Log.d("CRUD_Dialog", "No hay clientes para editar.")
                }
            }
            ActionType.DELETE -> {
                if (currentClients.isNotEmpty()) {
                    val randomClient = currentClients.random()
                    Log.d("CRUD_Dialog", "Capturando Eliminación -> ID: ${randomClient.id}")
                    onDeleteAction?.invoke(randomClient.id)
                } else {
                    Log.d("CRUD_Dialog", "No hay clientes para eliminar.")
                }
            }
        }
    }

    enum class ActionType { INSERT, UPDATE, DELETE }
}