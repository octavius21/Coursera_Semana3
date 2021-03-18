package com.example.semana3_3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MainActivity3 extends AppCompatActivity {
        String correo, contraseña;
        Session session;
        Button btnsiguiente;
        TextInputEditText tietNombre,tietCorreo,tietDescripcion,tietContraseña,tietDestinatario,tietAsunto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tietNombre=findViewById(R.id.tietNombre);
        tietCorreo=findViewById(R.id.tietCorreo);
        tietContraseña=findViewById(R.id.tietContraseña);
        tietAsunto=findViewById(R.id.tietAsunto);
        tietDestinatario=findViewById(R.id.tietDestinatario);
        tietDescripcion=findViewById(R.id.tietDescripcion);
        btnsiguiente=findViewById(R.id.btnSiguiente);
        btnsiguiente.setOnClickListener(new View.OnClickListener() {
            //TODO NOS VAMOS AL CORREO CLICK EN PERFIL->Cuenta->INICIO DE SESION Y SEGURIDAD->PERMITIR EL ACCESO DE APLICACION MENOS SEGURAS
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                if(tietCorreo.getText().toString().isEmpty()||tietContraseña.getText().toString().isEmpty()||tietDestinatario.getText().toString().isEmpty()||tietAsunto.getText().toString().isEmpty()
                ||tietDescripcion.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity3.this, "LLena los espacios", Toast.LENGTH_SHORT).show();
                }else{
                    Properties properties = new Properties();               //GMAIL/HOTMAIL
                    properties.put("mail.smtp.host", "smtp.googlemail.com");//smtp.live.com (SI)
                    properties.put("mail.smtp.starttls.enable","true");//(SI)
                    properties.put("mail.smtp.socketFactory.port", "465");//587
                    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    properties.put("mail.smtp.auth", "true");//(SI)
                    properties.put("mail.smtp.port", "465");//587 no se si vaya

                    try {
                        session = Session.getDefaultInstance(properties, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(tietCorreo.getText().toString(), tietContraseña.getText().toString());
                            }
                        });
                        if (session != null) {
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(tietCorreo.getText().toString()));
                            message.setSubject(tietAsunto.getText().toString());
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tietDestinatario.getText().toString().trim()));
                            message.setContent(tietDescripcion.getText().toString(), "text/html; charset=utf-8");
                            Transport.send(message);
                            /* Transport transport=session.getTransport("smtp");
                            transport.connect("smtp.live.com",587,correo,contraseña);
                            transport.sendMessage(message,message.getAllRecipients());
                            transport.close();
                             */
                            Toast.makeText(MainActivity3.this, "Se envio correo", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity3.this, "Hubo un error Verificque", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}