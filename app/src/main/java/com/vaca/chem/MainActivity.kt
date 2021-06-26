package com.vaca.chem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.vaca.chem.databinding.ActivityMainBinding
import java.nio.charset.StandardCharsets.US_ASCII

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ga="H2+Ca(CN)2+NaAlF4+FeSO4+MgSiO3+KI+H3PO4+PbCrO4+BrCl+CF2Cl2+SO2=PbBr2+CrCl3+MgCO3+KAl(OH)4+Fe(SCN)3+PI3+Na2SiO3+CaF2+H2O"
        // Example of a call to a native method
        binding.sampleText.text = chemBalan(ga.toByteArray(US_ASCII))
        val sa="H2+O2=H2O";
        binding.sampleText.text = chemBalan(sa.toByteArray(US_ASCII))
    }



    external fun chemBalan(chem: ByteArray): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("chem")
        }
    }
}