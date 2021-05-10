package com.example.ui.adapters

import android.net.Uri
import android.view.View
import coil.load
import com.example.domain.models.Character
import com.example.ui.R
import com.example.ui.databinding.CharacterListItemBinding
import com.xwray.groupie.viewbinding.BindableItem

class CharacterListItem(private val character: Character): BindableItem<CharacterListItemBinding>() {

    override fun bind(viewBinding: CharacterListItemBinding, position: Int) {
        viewBinding.apply {
            characterName.text = character.name
            characterStatus.text = character.status
            characterSpecies.text = character.species
            characterImg.load(character.image)
        }
    }

    override fun getLayout(): Int {
        return R.layout.character_list_item
    }

    override fun initializeViewBinding(view: View): CharacterListItemBinding {
        return CharacterListItemBinding.bind(view)
    }
}