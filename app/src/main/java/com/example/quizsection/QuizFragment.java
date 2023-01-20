package com.example.quizsection;

import android.annotation.SuppressLint;
import android.graphics.fonts.Font;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import com.example.quizsection.databinding.FragmentQuizBinding;
import com.example.quizsection.model.QuestionModelClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuizFragment extends Fragment {
    private FragmentQuizBinding binding;
    int counter = 1;
    public QuizFragment() {
        // Required empty public constructor
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        List<QuestionModelClass> list = new ArrayList<>();
        list.add(new QuestionModelClass("If x is a set and the set contains an integer which is neither positive nor negative then the set x is ____________.", "Set is Empty", "Set is Non-Empty", "Set is Finite", "Set is Non-Empty and Finite", "Set is Non-Empty and Finite"));
        list.add(new QuestionModelClass(" If x ∈ N and x is prime, then x is ________ set.", "Infinite set", "Finite set", "Empty set", "Not a set", "Infinite set"));
        list.add(new QuestionModelClass(" If x is a set and the set contains the real number between 1 and 2, then the set is ________.", "Empty set", "Finite set", "Infinite set", "Non of these", "Infinite set"));
        list.add(new QuestionModelClass("Which of the following is a subset of set {1, 2, 3, 4}?", "{1,2}", "{1,2,3}", "{1}", "All of the above", "All of the above"));
        list.add(new QuestionModelClass("Convert the set x in roster form if set x contains the positive prime number, which divides 72.", "{∅}", "{2,3}", "{2,3,7}", "{3,5,7}", "{2,3}"));
        list.add(new QuestionModelClass(" Power set of empty or Null set has exactly _________ subset.", "One", "Two", "Zero", "Three", "One"));
        list.add(new QuestionModelClass("What is the Cartesian product of set A and set B, if the set A = {1, 2} and set B = {a, b}?", "{(1,a),(1, b),(2, a),(b, b)}", "{(1,1),(2,2),(a,a),(b,b)}", "{(1,a),(2,a),(1,b),(2,b)}", "{(1,1),(a,a),(2,a),(1,b)}", "{(1,a),(2,a),(1,b),(2,b)}"));
        list.add(new QuestionModelClass("The members of the set S = {x | x is the square of an integer and x < 100} is _____", "{0,2,4,5,9,55,46,49,99,81}\n", "{1,4,9,16}", "{0,1,4,9,16,25,36,49,64,81}", "{0,1,4,9,25,36,49,123}", "{0,1,4,9,16,25,36,49,64,81}"));
        list.add(new QuestionModelClass("{1,2,8,9,10,5} ∩ {1,2,6,10,12,15}", "{1,2,10}", "{5,6,12,15}", "{2,5,10,9}", "{1,6,12,9,8}", "{1,2,10}"));
        list.add(new QuestionModelClass("{1,2,3,6,8} - {1,2,5,6}", "{1,3}", "{5,6,8}", "{3,8}", "{2,6,5}", "{3,8}"));
        Collections.shuffle(list);
        binding.questionView.setText(list.get(0).getQuestions());
        binding.noOfQuestionsView.setText(counter + "/"+list.size());
        binding.option1.setText(list.get(0).getOptionA());
        binding.option2.setText(list.get(0).getOptionB());
        binding.option3.setText(list.get(0).getOptionC());
        binding.option4.setText(list.get(0).getOptionD());
        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.translate);

                if (counter < list.size()) {
                    binding.noOfQuestionsView.setText(String.valueOf((counter+1)+"/"+list.size()));

                    binding.questionView.setText(list.get(counter).getQuestions());

                    binding.option1.setText(list.get(counter).getOptionA());

                    binding.option2.setText(list.get(counter).getOptionB());

                    binding.option3.setText(list.get(counter).getOptionC());

                    binding.option4.setText(list.get(counter).getOptionD());

                }
                else{
                    binding.questionView.setText("Quiz Completed");
                    binding.noOfQuestionsView.setVisibility(View.GONE);
                    binding.option1.setVisibility(View.GONE);
                    binding.option2.setVisibility(View.GONE);
                    binding.option3.setVisibility(View.GONE);
                    binding.option4.setVisibility(View.GONE);
                    binding.nextBtn.setVisibility(View.GONE);
                }
                counter++;
            }
        });



        return binding.getRoot();
    }
}