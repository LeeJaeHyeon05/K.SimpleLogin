package com.example.ksimplelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    //여기에 아이디와 비밀번호를 말해준다
    private val p1 = idpassword("p1", "123")
    val all_id_p = p1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findViewById를 활용해 EditText 와 Button 을 불러온다
        val loginButton = findViewById<Button>(R.id.loginButton)
        val idText = findViewById<EditText>(R.id.idText)
        val passwordText = findViewById<EditText>(R.id.passwordText)


        loginButton.setOnClickListener {

            //input 값을 id 와 password 둘다 설정해준다
            val inputLogin = idText.text.trim().toString()
            val inputPassword = passwordText.text.trim().toString()


            // 간단 로그인을 위한 메인
            //만약 아이디와 비번이 인풋과 같으면 intent를 활용해 test 페이지를 보여준다
            if (inputLogin == all_id_p.id && inputPassword == all_id_p.password) {
                val intent = Intent(this, test::class.java )
                startActivity(intent)
            //만약 안 같고 비어있으면 이 구문을 실행
            } else {
                if (inputLogin.isNullOrEmpty() && inputPassword.isNullOrEmpty()) {
                    Toast.makeText(this, "아이디와 비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show()
                } //id 가 틀리면 실행
                else if(inputLogin!=p1.id) {
                    Toast.makeText(this, "존재하지 않는 아이디 입니다.", Toast.LENGTH_SHORT).show()

                } else { //나머지를 통과하고 비번이 틀리면 이것을 실행
                    Toast.makeText(this, "비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}