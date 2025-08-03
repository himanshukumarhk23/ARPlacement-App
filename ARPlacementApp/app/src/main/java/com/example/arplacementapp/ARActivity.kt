package com.example.arplacementapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.arplacementapp.R
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.Color
import com.google.ar.sceneform.rendering.MaterialFactory
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.ShapeFactory
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode

class ARActivity : AppCompatActivity() {

    private lateinit var arFragment: ArFragment
    private var modelPlaced = false  // Allow only one object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aractivity)

        arFragment = supportFragmentManager.findFragmentById(R.id.arFragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane, motionEvent ->

            if (!modelPlaced) {
                placeObject(hitResult)
                modelPlaced = true
            } else {
                Toast.makeText(this, "Drill already placed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun placeObject(hitResult: HitResult) {
        // Step 1: Create Anchor
        val anchor: Anchor = hitResult.createAnchor()

        // Step 2: Build Material
        MaterialFactory.makeOpaqueWithColor(this, Color(android.graphics.Color.RED))
            .thenAccept { material ->

                // Step 3: Create 3D shape (Cone or Cube)
                val cube = ShapeFactory.makeCube(
                    com.google.ar.sceneform.math.Vector3(0.1f, 0.1f, 0.1f),  // size
                    com.google.ar.sceneform.math.Vector3(0f, 0.05f, 0f),     // center
                    material
                )

                // Step 4: Create AnchorNode
                val anchorNode = AnchorNode(anchor)
                anchorNode.setParent(arFragment.arSceneView.scene)

                // Step 5: Add shape to scene
                val node = TransformableNode(arFragment.transformationSystem)
                node.setParent(anchorNode)
                node.renderable = cube
                node.select()
            }
    }
}
