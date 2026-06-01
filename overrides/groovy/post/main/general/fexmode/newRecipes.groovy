package post.main.general.fexmode

//bromine from dt
mods.gregtech.distillation_tower.recipeBuilder()
    .fluidInputs(fluid('salt_water') * 14000)
    .fluidOutputs(fluid('water') * 14000, fluid('bromine') * 1)
    .outputs(metaitem('dustSalt') * 28)
    .duration(2200).EUt(360)
    .buildAndRegister()
//remove distillery recipe
mods.gregtech.distillery.removeByOutput([metaitem('dustSalt') * 28], [fluid('bromine') * 1])

//bromobenzene
mods.gregtech.large_chemical_reactor.recipeBuilder()
    .inputs(metaitem('dustTinyIron'))
    .fluidInputs(fluid('benzene') * 1000, fluid('bromine') * 2000)
    .fluidOutputs(fluid('bromobenzene') * 3000)
    .duration(400).EUt(1920)
    .buildAndRegister()

//2-phenyl-2-propanol
mods.gregtech.large_chemical_reactor.recipeBuilder()
    .inputs(metaitem('dustMagnesium') * 2)
    .fluidInputs(fluid('bromobenzene') * 2000, fluid('ethyl_tertbutyl_ether') * 1000)
    .fluidOutputs(fluid('2_phenyl_2_propanol') * 3000)
    .duration(240).EUt(960)
    .buildAndRegister()

//dicumyl peroxide
mods.gregtech.large_chemical_reactor.recipeBuilder()
    .fluidInputs(fluid('2_phenyl_2_propanol') * 1000, fluid('hydrogen_peroxide') * 1000, fluid('sulfuric_acid') * 5)
    .outputs(metaitem('dustDicumylPeroxide') * 14)
    .duration(100).EUt(480)
    .buildAndRegister()

//hdpe
mods.gregtech.compressor.recipeBuilder()
    .inputs(metaitem('ingotPlastic') * 4)
    .outputs(metaitem('ingotHighDensityPolyethylene'))
    .duration(200).EUt(480)
    .buildAndRegister()

//liquid hdpe
mods.gregtech.extractor.recipeBuilder()
    .inputs(metaitem('ingotHighDensityPolyethylene'))
    .fluidOutputs(fluid('high_density_polyethylene') * 144)
    .duration(16).EUt(30)
    .buildAndRegister()

//liquid PEX
mods.gregtech.mixer.recipeBuilder()
    .inputs(metaitem('dustDicumylPeroxide'))
    .fluidInputs(fluid('high_density_polyethylene') * 7200)
    .fluidOutputs(fluid('crosslinked_polyethylene') * 7200)
    .duration(80).EUt(256)
    .buildAndRegister()

//PEX ingot
mods.gregtech.fluid_solidifier.recipeBuilder()
    .fluidInputs(fluid('crosslinked_polyethylene') * 144)
    .notConsumable(metaitem('shape.mold.ingot'))
    .outputs(metaitem('ingotCrosslinkedPolyethylene'))
    .duration(100).EUt(7)
    .buildAndRegister()

