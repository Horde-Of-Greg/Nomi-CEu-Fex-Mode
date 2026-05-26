package post.main.general.fexmode

//Diamond Hook diamonds -> plates
crafting.remove('hooked:diamond_hook')
crafting.shapedBuilder()
    .output(item('hooked:hook:2'))
    .matrix(
        ' PP',
        ' HP',
        'P  ')
    .key('H', item('hooked:hook:1'))
    .key('P', metaitem('plateDiamond'))
    .register()

//Vacuum Tube steel bolts -> steel rods
crafting.remove('gregtech:vacuum_tube')
crafting.shapedBuilder()
    .output(metaitem('circuit.vacuum_tube'))
    .matrix(
        '   ',
        'RGR',
        'WWW')
    .key('R', metaitem('stickSteel'))
    .key('G', metaitem('component.glass.tube'))
    .key('W', ore('wireGtSingleCopper'))
    .register()

//PBF changes
crafting.remove('gregtech:bronze_primitive_blast_furnace')
crafting.shapedBuilder()
    .output(metaitem('primitive_blast_furnace.bronze'))
    .matrix(
        'BPP',
        'WHP',
        'BPP')
    .key('B', item('gregtech:metal_casing:1')) //these are firebricks the metaitem name is fuhed or smn
    .key('P', metaitem('plateDoubleWroughtIron'))
    .key('W', ore('toolWrench'))
    .key('H', ore('blockCoke'))
    .register()

//cbt cupronickel coil
mods.gregtech.assembler.removeByInput(30, [metaitem('wireGtDoubleCupronickel') * 8, metaitem('foilBronze') * 8], [fluid('tin_alloy') * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('wireGtDoubleCupronickel') * 12, metaitem('foilBronze') * 12, metaitem('wireFineCopper') * 48)
    .fluidInputs(fluid('tin_alloy') * 288)
    .outputs(item('gregtech:wire_coil:0'))
    .duration(400).EUt(30)
    .buildAndRegister()

//lv energy hatch now requires 250mb of NaK
crafting.remove('gregtech:energy_hatch.lv')
mods.gregtech.assembler.removeByInput(30, [metaitem('hull.lv'), metaitem('cableGtSingleTin') * 2, metaitem('voltage_coil.lv')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('cableGtSingleTin') * 2, metaitem('voltage_coil.lv'))
    .fluidInputs(fluid('sodium_potassium') * 250)
    .outputs(metaitem('energy_hatch.input.lv'))
    .duration(200).EUt(30)
    .buildAndRegister()

//pyro oven changes
crafting.remove('nomiceu:pyrolyse_oven')
crafting.shapedBuilder()
    .output(metaitem('pyrolyse_oven'))
    .matrix(
        'ECW',
        'CHC',
        'EPL')
    .key('E', metaitem('electric.piston.lv'))
    .key('C', ore('circuitLv'))
    .key('W', ore('wireGtHexSteel'))
    .key('H', metaitem('hull.ulv'))
    .key('P', metaitem('electric.pump.lv'))
    .key('L', ore('pipeHugeFluidLead'))
    .register()





