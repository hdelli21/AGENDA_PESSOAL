package com.exemplo.agenda.controller;

import com.exemplo.agenda.model.ContatoModel;
import com.exemplo.agenda.view.ContatoView;
import com.exemplo.agenda.model.Contato;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Classe responsável por controlar a interação entre a View e o Model.
 */
public class ContatoController {
    private ContatoView view;
    private ContatoModel model;

    /**
     * Construtor do ContatoController.
     *
     * @param view  A interface gráfica que o usuário vê e interage.
     * @param model O modelo que lida com os dados.
     */
    public ContatoController(ContatoView view, ContatoModel model) {
        this.view = view;
        this.model = model;
        inicializarAcoes();
    }

    /**
     * Inicializa os eventos dos botões da interface gráfica.
     * Este método associa os botões de ação na interface gráfica às ações apropriadas no modelo.
     */
    private void inicializarAcoes() {
        // Ação do botão Adicionar
        view.getBtnAdicionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = view.getTxtNome().getText();
                String telefone = view.getTxtTelefone().getText();
                
                if (nome.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nome e telefone não podem ser vazios!");
                    return;
                }
                
                model.adicionarContato(nome, telefone);
                JOptionPane.showMessageDialog(view, "Contato adicionado com sucesso!");
            }
        });

        // Ação do botão Atualizar
        view.getBtnAtualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTabelaContatos().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Selecione um contato para atualizar.");
                    return;
                }

                int id = Integer.parseInt(view.getModel().getValueAt(selectedRow, 0).toString());
                String nome = view.getTxtNome().getText();
                String telefone = view.getTxtTelefone().getText();

                if (nome.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nome e telefone não podem ser vazios!");
                    return;
                }

                model.atualizarContato(id, nome, telefone);
                JOptionPane.showMessageDialog(view, "Contato atualizado com sucesso!");
            }
        });

        // Ação do botão Deletar
        view.getBtnDeletar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getTabelaContatos().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Selecione um contato para deletar.");
                    return;
                }

                int id = Integer.parseInt(view.getModel().getValueAt(selectedRow, 0).toString());
                model.deletarContato(id);
                JOptionPane.showMessageDialog(view, "Contato deletado com sucesso!");
            }
        });

        // Ação do botão Listar
        view.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Contato> contatos = model.listarContatos();
                view.getModel().setRowCount(0); // Limpa a tabela
                for (Contato contato : contatos) {
                    view.getModel().addRow(new Object[]{
                            contato.getId(),
                            contato.getNome(),
                            contato.getTelefone()
                    });
                }
            }
        });
    }
}
