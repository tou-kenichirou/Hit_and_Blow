package com.example.hitblow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_sub1.*
import kotlinx.android.synthetic.main.fragment_sub1.view.*

class SubFragment1 : Fragment(){
    private val list = (0..9).toList()
    private val shuffle = list.shuffled()
    private val no1 = shuffle[0]
    private val no2 = shuffle[1]
    private val no3 = shuffle[2]
    private val no4 = shuffle[3]
    private var count1 = 0
    private var count2 = 0
    private var count3 = 0
    private var count4 = 0
    private var hitCount = 0
    private var blowCount = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub1, container, false)
        view.button.setOnClickListener{
            findNavController().navigate(R.id.action_sub1_to_main)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 1_button
        up_1.setOnClickListener{
            if(count1 + 1 >= 10){
                count1 = 9
            }else{
                count1 ++
            }
            count_1.text=count1.toString()
        }
        down_1.setOnClickListener{
            if(count1 - 1 <= 0){
                count1 = 0
            }else{
                count1 --
            }
            count_1.text=count1.toString()
        }

        // 2_button
        up_2.setOnClickListener{
            if(count2 + 1 >= 10){
                count2 = 9
            }else{
                count2 ++
            }
            count_2.text=count2.toString()
        }
        down_2.setOnClickListener{
            if(count2 - 1 <= 0){
                count2 = 0
            }else{
                count2 --
            }
            count_2.text=count2.toString()
        }

        // 3_button
        up_3.setOnClickListener{
            if(count3 + 1 >= 10){
                count3 = 9
            }else{
                count3 ++
            }
            count_3.text=count3.toString()
        }
        down_3.setOnClickListener{
            if(count3 - 1 <= 0){
                count3 = 0
            }else{
                count3 --
            }
            count_3.text=count3.toString()
        }

        // 4_button
        up_4.setOnClickListener{
            if(count4 + 1 >= 10){
                count4 = 9
            }else{
                count4 ++
            }
            count_4.text=count4.toString()
        }
        down_4.setOnClickListener{
            if(count4 - 1 <= 0){
                count4 = 0
            }else{
                count4 --
            }
            count_4.text=count4.toString()
        }

        // check_button
        total_button.setOnClickListener{
            // count1の比較
            if (count1 == no1){
                hitCount ++
            }else if(count1 == no2 || count1 == no3 || count1 == no4){
                blowCount ++
            }
            // count2の比較
            if (count2 == no2){
                hitCount ++
            }else if(count2 == no1 || count2 == no3 || count2 == no4){
                blowCount ++
            }
            // count3の比較
            if (count3 == no3){
                hitCount ++
            }else if(count3 == no1 || count3 == no2 || count3 == no4){
                blowCount ++
            }
            // count4の比較
            if (count4 == no4){
                hitCount ++
            }else if(count4 == no1 || count4 == no2 || count4 == no3){
                blowCount ++
            }

            // count表示
            hit_int.text = hitCount.toString()
            blow_int.text = blowCount.toString()

            // 正解判定
            if (hitCount == 4){
                question1.text = count1.toString()
                question2.text = count2.toString()
                question3.text = count3.toString()
                question4.text = count4.toString()
                success.text = "success!!"
            }
        }
    }
}