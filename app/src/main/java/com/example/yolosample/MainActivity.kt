package com.example.yolosample

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var selectModelBtn: Button
    private lateinit var selectImageBtn: Button
    private lateinit var inferBtn: Button
    private lateinit var imageView: ImageView
    private lateinit var resultText: TextView

    private var modelUri: Uri? = null
    private var imageUri: Uri? = null

    // モデルファイルを選択するActivityResultLauncher
    private val selectModelLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()) { uri ->
        modelUri = uri
        selectModelBtn.text = "モデル選択済"
        checkEnableInfer()
    }

    // 画像を選択するActivityResultLauncher
    private val selectImageLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
        imageView.setImageURI(imageUri)
        checkEnableInfer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectModelBtn = findViewById(R.id.selectModelBtn)
        selectImageBtn = findViewById(R.id.selectImageBtn)
        inferBtn = findViewById(R.id.inferBtn)
        imageView = findViewById(R.id.imageView)
        resultText = findViewById(R.id.resultText)

        selectModelBtn.setOnClickListener {
            selectModelLauncher.launch("application/octet-stream")
        }

        selectImageBtn.setOnClickListener {
            selectImageLauncher.launch("image/*")
        }

        inferBtn.setOnClickListener {
            if (modelUri != null && imageUri != null) {
                // ここにONNXモデル呼び出し推論処理を追加予定
                resultText.text = "推論中..."
                inferBtn.isEnabled = false
                inferBtn.postDelayed({
                    val dummyCount = (1..10).random()
                    resultText.text = "検出部品数：${dummyCount}個（ダミー）"
                    inferBtn.isEnabled = true
                }, 1500)
            }
        }
        inferBtn.isEnabled = false
    }

    // 推論開始ボタンの有効化チェック
    private fun checkEnableInfer() {
        inferBtn.isEnabled = (modelUri != null && imageUri != null)
    }
}
