package com.example.exercicio4.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercicio4.R
import com.example.exercicio4.data.model.Status
import com.example.exercicio4.data.model.Task
import com.example.exercicio4.databinding.FragmentDoneBinding
import com.example.exercicio4.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {
    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecyclerViewTask(taskList: List<Task>) {
        taskAdapter = TaskAdapter(taskList)
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)
        binding.recyclerViewTask.adapter = taskAdapter
    }

    private fun getTask() = listOf(
        Task("0", "Criar nova tela do app", Status.TODO),
        Task("1", "Validar informações na tela de login", Status.TODO),
        Task("2", "Adicionar nova funcionalidade no app", Status.TODO),
        Task("3", "Salvar token Localmente", Status.TODO),
        Task("2", "Criar funcionalidade de logout no app", Status.TODO),
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}