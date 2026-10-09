package com.example.simulacioncrudluis.Views

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.simulacioncrudluis.Logic.Controller
import com.example.simulacioncrudluis.R

class MainActivity : ComponentActivity() {
    private lateinit var controller: Controller
    private lateinit var simulatedDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = Controller()
        simulatedDialog = Dialog()

        // Pasamos las funciones del controlador encapsuladas en lambdas
        simulatedDialog.setActions(
            onAdd = { id, name, telf -> controller.controllerAdd(id, name, telf) },
            onDelete = { id -> controller.controllerDelete(id) },
            onUpdate = { id, name, telf -> controller.controllerUpdate(id, name, telf) }
        )

        findViewById<Button>(R.id.btnInsert).setOnClickListener {
            simulatedDialog.show(Dialog.ActionType.INSERT, controller.getClients())
        }

        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            simulatedDialog.show(Dialog.ActionType.UPDATE, controller.getClients())
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            simulatedDialog.show(Dialog.ActionType.DELETE, controller.getClients())
        }
    }
}
