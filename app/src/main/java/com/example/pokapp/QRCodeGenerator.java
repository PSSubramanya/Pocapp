package com.example.pokapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCodeGenerator extends AppCompatActivity {

    private EditText etInput;
    private Button btnCreateQR;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_generator);

        etInput = findViewById(R.id.etInput);
        btnCreateQR = findViewById(R.id.btnCreateQR);
        imageView = findViewById(R.id.imageView);


        btnCreateQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = etInput.getText().toString().trim();

                if (txt != null)
                {
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try
                    {
                        BitMatrix bitMatrix = multiFormatWriter.encode(txt, BarcodeFormat.QR_CODE,500,500);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        imageView.setImageBitmap(bitmap);
                    } catch (WriterException e)
                    {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}
