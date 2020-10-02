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

    // questionの停止判定
    private var stop1 = false
    private var stop2 = false
    private var stop3 = false
    private var stop4 = false

    // countの停止判定
    private var stopCount1 = false
    private var stopCount2 = false
    private var stopCount3 = false
    private var stopCount4 = false

    private var hitCount = 0
    private var blowCount = 0
    private var checkCount = 0
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
            // count1の成否
            if (count1 == no1){
                hitCount ++
                stop1 = true
                stopCount1 = true
            }
            // count2の成否
            if (count2 == no2){
                hitCount ++
                stop2 = true
                stopCount2 = true
            }
            // count3の成否
            if (count3 == no3){
                hitCount ++
                stop3 = true
                stopCount3 = false
            }
            // count4の成否
            if (count4 == no4){
                hitCount ++
                stop4 = true
                stopCount4 = false
            }


            if (!stop1 && !stopCount2 && count2 == no1){
                blowCount ++
                stop1 = true
                stopCount2 = true
            }
            if (!stop1 && !stopCount3 && count3 == no1){
                blowCount ++
                stop1 = true
                stopCount3 = true
            }
            if (!stop1 && !stopCount4 && count4 == no1){
                blowCount ++
                stop1 = true
                stopCount4 = true
            }

            if (!stop2 && !stopCount1 && count1 == no2){
                blowCount ++
                stop2 = true
                stopCount1 = true
            }
            if (!stop2 && !stopCount3 && count3 == no2){
                blowCount ++
                stop2 = true
                stopCount3 = true
            }
            if (!stop2 && !stopCount4 && count4 == no2){
                blowCount ++
                stop2 = true
                stopCount4 = true
            }

            if (!stop3 && !stopCount1 && count1 == no3){
                blowCount ++
                stop3 = true
                stopCount1 = true
            }
            if (!stop3 && !stopCount2 && count2 == no3){
                blowCount ++
                stop3 = true
                stopCount2 = true
            }
            if (!stop3 && !stopCount4 && count4 == no3){
                blowCount ++
                stop3 = true
                stopCount4 = true
            }

            if (!stop4 && !stopCount1 && count1 == no4){
                blowCount ++
                stop4 = true
                stopCount1 = true
            }
            if (!stop4 && !stopCount2 && count2 == no4){
                blowCount ++
                stop4 = true
                stopCount2 = true
            }
            if (!stop4 && !stopCount3 && count3 == no4){
                blowCount ++
                stop4 = true
                stopCount3 = true
            }

            // count表示
            hit_int.text = hitCount.toString()
            blow_int.text = blowCount.toString()

            // 正解判定
            if (hitCount == 4){
                question1.text = no1.toString()
                question2.text = no2.toString()
                question3.text = no3.toString()
                question4.text = no4.toString()
                success.text = "success!!"
            }

            // checkCount
            checkCount ++
            check_count.text = checkCount.toString()

            // 初期化
            stop1 = false
            stop2 = false
            stop3 = false
            stop4 = false
            stopCount1 = false
            stopCount2 = false
            stopCount3 = false
            stopCount4 = false
            hitCount = 0
            blowCount = 0

            // debug
           // question1.text = no1.toString()
           // question2.text = no2.toString()
           // question3.text = no3.toString()
           // question4.text = no4.toString()

        }
    }
}