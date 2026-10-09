package com.example.simulacioncrudluis.Views

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.simulacioncrudluis.Logic.Controller
import com.example.simulacioncrudluis.Logic.interfaces.interfazCliente
import com.example.simulacioncrudluis.R

class MainActivity : ComponentActivity(), interfazCliente {
    private lateinit var controller: Controller
    private lateinit var simulatedDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar Controller y Dialog
        controller = Controller()
        simulatedDialog = Dialog()

        // Pasamos la referencia de esta clase (que implementa OperationsInterface)
        simulatedDialog.setListener(this)

        // Capturar eventos de botones
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

    override fun ClientAdd(id: Int, name: String) {
        controller.controllerAdd(id, name)
    }

    override fun ClientDel(id: Int) {
        controller.controllerDelete(id)
    }

    override fun ClientUpdate(id: Int, name: String) {
        controller.controllerUpdate(id, name)
    }
}
