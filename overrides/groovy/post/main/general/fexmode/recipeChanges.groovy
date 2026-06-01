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

//cbt coils
//cupronickel
mods.gregtech.assembler.removeByInput(
  30,
  [metaitem('wireGtDoubleCupronickel') * 8, metaitem('foilBronze') * 8],
  [fluid('tin_alloy') * 144]
)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('wireGtDoubleCupronickel') * 12, metaitem('foilBronze') * 12, metaitem('wireFineCopper') * 48)
    .fluidInputs(fluid('tin_alloy') * 288)
    .outputs(item('gregtech:wire_coil:0'))
    .duration(400).EUt(30)
    .buildAndRegister()

//kanthal
mods.gregtech.assembler.removeByInput(120,
    [metaitem('wireGtDoubleKanthal') * 8,
     metaitem('foilAluminium') * 8],
    [fluid('copper') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('wireGtDoubleKanthal') * 12, metaitem('foilAluminium') * 12, ore('wireFineZinc') * 48)
    .fluidInputs(fluid('molybdenum') * 576)
    .outputs(item('gregtech:wire_coil:1'))
    .duration(600).EUt(120)
    .buildAndRegister()

//nichrome
mods.gregtech.assembler.removeByInput(480,
    [metaitem('wireGtDoubleNichrome') * 8,
     metaitem('foilStainlessSteel') * 8],
    [fluid('aluminium') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('wireGtDoubleNichrome') * 16, metaitem('foilStainlessSteel') * 16, ore('wireFinePlatinum') * 64)
    .fluidInputs(fluid('ultimet') * 576)
    .outputs(item('gregtech:wire_coil:2'))
    .duration(1000).EUt(480)
    .buildAndRegister()

//rtm
mods.gregtech.assembler.removeByInput(1920,
    [metaitem('wireGtDoubleRtmAlloy') * 8,
     metaitem('foilVanadiumSteel') * 8],
    [fluid('nichrome') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('wireGtDoubleRtmAlloy') * 24, metaitem('foilVanadiumSteel') * 24, ore('stickLongTitanium') * 12)
    .fluidInputs(fluid('cobalt') * 1152)
    .outputs(item('gregtech:wire_coil:3'))
    .duration(1400).EUt(1920)
    .buildAndRegister()

//hss-g
mods.gregtech.assembler.removeByInput(7680,
    [metaitem('wireGtDoubleHssg') * 8,
     metaitem('foilTungstenCarbide') * 8],
    [fluid('tungsten') * 144 * 144])
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('frameGtHssg'),
        ore('wireGtDoubleHssg') * 48,
        metaitem('plateTungstenCarbide') * 24,
        ore('stickLongVanadiumGallium') * 16,
        ore('circuitLuv') * 2)
    .fluidInputs(fluid('molten.hsse') * 1728)
    .outputs(item('gregtech:wire_coil:4'))
    .duration(2000).EUt(7680)
    .buildAndRegister()

//voltage coil changes
//remove all voltage coil recipes lv+
for (var tier: ['lv', 'mv', 'hv', 'ev', 'iv', 'luv', 'zpm', 'uv']) {
    mods.gregtech.assembler.removeByOutput([metaitem("voltage_coil.${tier}")], null)
}

void addVoltageCoilAss (Collection<ItemStack> output,
                        Collection<IIngredient> input,
                        IIngredient fluid, Integer length,
                        Integer energy) {
    mods.gregtech.assembler.recipeBuilder()
        .inputs(input)
        .circuitMeta(1)
        .fluidInputs(fluid)
        .outputs(output)
        .duration(length).EUt(energy)
        .buildAndRegister()
}

//lv coil
addVoltageCoilAss([metaitem('voltage_coil.lv')],
    [metaitem('stickIronMagnetic'),
     metaitem('wireFineSteel') * 32],
    fluid('lead') * 288, 200, 30)
//mv coil
addVoltageCoilAss([metaitem('voltage_coil.mv')],
    [metaitem('stickSteelMagnetic') * 2,
     metaitem('wireFineAluminium') * 64],
    fluid('steel') * 576, 320, 120)
//hv coil
addVoltageCoilAss([metaitem('voltage_coil.hv')],
    [metaitem('stickNeodymiumMagnetic') * 2,
     metaitem('wireFineStainlessSteel') * 64,
     metaitem('wireFineStainlessSteel') * 64],
    fluid('antimony') * 576, 400, 480)
//ev coil
addVoltageCoilAss([metaitem('voltage_coil.ev')],
    [metaitem('stickNeodymiumMagnetic') * 4,
     metaitem('wireGtSinglePlatinum') * 64,
     metaitem('boltTitanium') * 64],
    fluid('tantalum') * 864, 600, 1920)
//iv coil
addVoltageCoilAss([metaitem('voltage_coil.iv')],
    [metaitem('stickLongSamariumMagnetic') * 6,
     metaitem('wireFineIridium') * 64,
     metaitem('wireFineIridium') * 64,
     metaitem('foilIridium') * 64,
     metaitem('foilIridium') * 64,],
    fluid('bismuth') * 1728, 1000, 7680)

//luv coil
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('blockSamariumMagnetic'),
        metaitem('stickLongSamariumMagnetic') * 12,
        metaitem('ringOsmiridium') * 64,
        metaitem('gearSmallOsmiridium') * 24,
        metaitem('plateOsmiridium') * 16)
    .fluidInputs(fluid('berkelium') * 1296, fluid('liquid_helium') * 4000)
    .outputs(metaitem('voltage_coil.luv'))
    .scannerResearch(b -> b.researchStack(metaitem('voltage_coil.iv')))
    .duration(1800).EUt(30720)
    .buildAndRegister()

//zpm coil
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(item('nomilabs:magnetron') * 2,
        metaitem('stickLongSamariumMagnetic') * 24,
        metaitem('plateDoubleEuropium') * 16,
        metaitem('foilEuropium') * 64,
        metaitem('wireGtDoubleEuropium') * 64,
        metaitem('springEuropium') * 12)
    .fluidInputs(fluid('californium') * 2592, fluid('liquid_helium') * 16000)
    .outputs(metaitem('voltage_coil.zpm'))
    .stationResearch(b -> b.researchStack(metaitem('voltage_coil.luv')).CWUt(8))
    .duration(3200).EUt(122880)
    .buildAndRegister()

//uv coil
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(item('nomilabs:magnetron') * 8,
        metaitem('stickLongSamariumMagnetic') * 64,
        metaitem('plateDenseTritanium') * 6,
        metaitem('ringTritanium') * 64,
        metaitem('gearSmallTritanium') * 48,
        metaitem('foilTritanium') * 64,
        metaitem('foilTritanium') * 64,
        metaitem('wireGtDoubleTritanium') * 64,
        metaitem('wireGtQuadrupleTritanium') * 24,
        metaitem('springTritanium') * 16)
    .fluidInputs(fluid('plasma.argon') * 10368, fluid('liquid_helium') * 80000)
    .outputs(metaitem('voltage_coil.uv'))
    .stationResearch(b -> b.researchStack(metaitem('voltage_coil.zpm')).CWUt(64))
    .duration(5600).EUt(491520)
    .buildAndRegister()

//remove all energy hatch recipes
for (var hatchTier: ['lv', 'mv']) {
    crafting.remove("gregtech:energy_hatch.${hatchTier}")
    mods.gregtech.assembler.removeByOutput([metaitem("energy_hatch.input.$hatchTier")], null)
}

for (var hatchTier: ['hv', 'ev', 'iv']) {
    mods.gregtech.assembler.removeByOutput([metaitem("energy_hatch.input.${hatchTier}")], null)
}

for (var hatchTier: ['luv', 'zpm', 'uv', 'uhv']) {
    mods.gregtech.assembly_line.removeByOutput([metaitem("energy_hatch.input.${hatchTier}")], null)
}

//lv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('cableGtSingleTin') * 2, metaitem('voltage_coil.lv'))
    .fluidInputs(fluid('sodium_potassium') * 250)
    .outputs(metaitem('energy_hatch.input.lv'))
    .duration(200).EUt(30)
    .buildAndRegister()

//mv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.mv'), metaitem('cableGtSingleCopper') * 2,
        metaitem('voltage_coil.mv'), metaitem('electric.pump.mv'),
        metaitem('plate.ultra_low_power_integrated_circuit') * 2)
    .fluidInputs(fluid('sodium_potassium') * 500)
    .outputs(metaitem('energy_hatch.input.mv'))
    .duration(400).EUt(120)
    .buildAndRegister()

//hv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.hv'), metaitem('cableGtSingleGold') * 4,
        metaitem('voltage_coil.hv'), metaitem('electric.pump.hv'),
        metaitem('plate.low_power_integrated_circuit') * 4)
    .fluidInputs(fluid('sodium_potassium') * 1000)
    .outputs(metaitem('energy_hatch.input.hv'))
    .duration(600).EUt(480)
    .buildAndRegister()

//ev energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.ev'), metaitem('cableGtSingleAluminium') * 8,
        metaitem('voltage_coil.ev'), metaitem('electric.pump.ev') * 2,
        metaitem('plate.power_integrated_circuit') * 6, ore('circuitEv'))
    .fluidInputs(fluid('sodium_potassium') * 2000)
    .outputs(metaitem('energy_hatch.input.ev'))
    .duration(900).EUt(1920)
    .buildAndRegister()

//iv energy hatch
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('charger.iv'), metaitem('cableGtSingleTungsten') * 16,
        metaitem('voltage_coil.iv'), metaitem('fluid.regulator.iv') * 2,
        metaitem('plate.high_power_integrated_circuit') * 12, ore('circuitIv'))
    .fluidInputs(fluid('sodium_potassium') * 4000)
    .outputs(metaitem('energy_hatch.input.iv'))
    .duration(1400).EUt(7680)
    .buildAndRegister()

//luv energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('charger.luv'), metaitem('cableGtSingleNiobiumTitanium') * 16,
        metaitem('voltage_coil.luv'), metaitem('fluid.regulator.luv') * 2,
        metaitem('wafer.high_power_integrated_circuit') * 12, metaitem('plate.ultra_high_power_integrated_circuit') * 8,
        ore('circuitLuv') * 2)
    .fluidInputs(fluid('sodium_potassium') * 8000, fluid('soldering_alloy') * 1440,
        fluid('indium_tin_barium_titanium_cuprate') * 720)
    .outputs(metaitem('energy_hatch.input.luv'))
    .scannerResearch(b -> b.researchStack(metaitem('energy_hatch.input.iv')))
    .duration(2400).EUt(30720)
    .buildAndRegister()

//zpm energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('charger.zpm'), metaitem('cableGtSingleVanadiumGallium') * 16,
        metaitem('voltage_coil.zpm') * 2, metaitem('fluid.regulator.zpm') * 2,
        metaitem('wafer.high_power_integrated_circuit') * 20, metaitem('plate.ultra_high_power_integrated_circuit') * 16,
        ore('circuitZpm') * 4)
    .fluidInputs(fluid('sodium_potassium') * 16000, fluid('soldering_alloy') * 2880,
        fluid('uranium_rhodium_dinaquadide') * 1440)
    .outputs(metaitem('energy_hatch.input.zpm'))
    //this adds research but it doesnt work with the custom CWU and eu parameters
    .stationResearch(b -> b.researchStack(metaitem('energy_hatch.input.luv')).CWUt(16).EUt(30720))
    .duration(3600).EUt(122880)
    .buildAndRegister()

//uv energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('charger.uv'), metaitem('cableGtSingleYttriumBariumCuprate') * 16,
        metaitem('voltage_coil.uv') * 2, metaitem('fluid.regulator.uv') * 4,
        metaitem('wafer.high_power_integrated_circuit') * 32, metaitem('plate.ultra_high_power_integrated_circuit') * 32,
        ore('circuitUv') * 4)
    .fluidInputs(fluid('sodium_potassium') * 32000, fluid('soldering_alloy') * 5760,
        fluid('enriched_naquadah_trinium_europium_duranide') * 2880)
    .outputs(metaitem('energy_hatch.input.uv'))
    .stationResearch(b -> b.researchStack(metaitem('energy_hatch.input.zpm')).CWUt(64).EUt(122880))
    .duration(6000).EUt(491520)
    .buildAndRegister()

//uhv energy hatch
mods.gregtech.assembly_line.recipeBuilder()
    .inputs(metaitem('substation_hatch.input_64a.uv'),
        metaitem('cableGtSingleEuropium') * 16, item('gregtech:fusion_casing:4'),
        metaitem('wafer.high_power_integrated_circuit') * 64, metaitem('plate.ultra_high_power_integrated_circuit') * 64,
        ore('plateDoubleAwakenedDraconium') * 16, ore('circuitUhv') * 16)
    .fluidInputs(fluid('sodium_potassium') * 64000, fluid('soldering_alloy') * 11520,
        fluid('ruthenium_trinium_americium_neutronate') * 5760)
    .outputs(metaitem('energy_hatch.input.uhv'))
    .stationResearch(b -> b.researchStack(metaitem('energy_hatch.input.uv')).CWUt(256).EUt(1966080))
    .duration(6400).EUt(1966080)
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

//pbf recipes changes
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('ingotSteel'), metaitem('dustTinyDarkAsh') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('ingotSteel'), metaitem('dustTinyAsh')], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('blockSteel'), metaitem('dustDarkAsh') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByOutput([metaitem('blockSteel'), metaitem('dustAsh')], null)
mods.gregtech.primitive_blast_furnace.recipeBuilder()
    .inputs(item('minecraft:iron_ingot'), metaitem('gemCoke') * 2)
    .outputs(metaitem('ingotSteel'))
    .duration(2400).EUt(1)
    .buildAndRegister()

//ebf steel changes
mods.gregtech.electric_blast_furnace.removeByInput(120, [item('minecraft:iron_ingot')], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustIron'), metaitem('circuit.integrated').withNbt(['Configuration': 2])], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('ingotWroughtIron')], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustWroughtIron'), metaitem('circuit.integrated').withNbt(['Configuration': 2])], [fluid('oxygen') * 200 * 200])
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustIron') * 4, metaitem('dustCarbon')], null)
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustWroughtIron') * 4, metaitem('dustCarbon')], null)
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(ore('ingotIron'))
    .fluidInputs(fluid('oxygen') * 360)
    .outputs(metaitem('ingotSteel'))
    .property('temperature', 1800)
    .duration(120).EUt(480)
    .buildAndRegister()

//silicon boule buff
mods.gregtech.electric_blast_furnace.removeByInput(120,
    [metaitem('dustSilicon') * 32, metaitem('dustSmallGalliumArsenide'),
     metaitem('circuit.integrated').withNbt(['Configuration': 2])],
    null
)

mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustSilicon') * 64, metaitem('dustGalliumArsenide'))
    .circuitMeta(3)
    .fluidInputs(fluid('nitrogen') * 48000)
    .outputs(metaitem('boule.silicon'))
    .duration(47000).EUt(120)
    .property('temperature', 1784)
    .buildAndRegister()

//basic wafer cutting changes
mods.gregtech.cutter.removeByOutput([metaitem('wafer.silicon') * 16], null)
mods.gregtech.cutter.recipeBuilder()
    .inputs(metaitem('boule.silicon'))
    .fluidInputs(fluid('lubricant') * 200)
    .outputs(metaitem('wafer.silicon') * 16)
    .duration(1200).EUt(64)
    .buildAndRegister()

//lbb changes
crafting.remove('gregtech:large_bronze_boiler')
crafting.shapedBuilder()
    .output(metaitem('large_boiler.bronze'))
    .matrix(
        'WCW',
        'CHC',
        'WCW')
    .key('W', metaitem('cableGtOctalAnnealedCopper'))
    .key('C', ore('circuitLv'))
    .key('H', item('gregtech:turbine_casing:0')) //bronze gearbox
    .register()

//maintenance hatch changes
crafting.remove('gregtech:maintenance_hatch')
mods.gregtech.assembler.removeByInput(
    30,
    [metaitem('hull.lv'), metaitem('circuit.integrated').withNbt(['Configuration': 8])], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('hull.lv'), metaitem('plateIron') * 2, metaitem('plateLead') * 2, metaitem ('ringRubber'))
    .circuitMeta(8)
    .outputs(metaitem('maintenance_hatch'))
    .duration(200).EUt(30)
    .buildAndRegister()

//lv circuit assembler
crafting.remove('gregtech:gregtech.machine.circuit_assembler.lv')
crafting.shapedBuilder()
    .output(metaitem('circuit_assembler.lv'))
    .matrix(
        'APE',
        'CHC',
        'MFM')
    .key('A', metaitem('robot.arm.lv'))
    .key('P', metaitem('pipeNormalFluidLead'))
    .key('E', metaitem('emitter.lv'))
    .key('C', metaitem('conveyor.module.lv'))
    .key('H', metaitem('hull.lv'))
    .key('M', ore('circuitMv'))
    .key('F', metaitem('field.generator.lv'))
    .register()

//mv circuit assembler
crafting.remove('gregtech:gregtech.machine.circuit_assembler.mv')
crafting.shapedBuilder()
    .output(metaitem('circuit_assembler.mv'))
    .matrix(
        'APE',
        'CHC',
        'MFM')
    .key('A', metaitem('robot.arm.mv'))
    .key('P', metaitem('pipeNormalFluidVanadiumSteel'))
    .key('E', metaitem('emitter.mv'))
    .key('C', metaitem('conveyor.module.mv'))
    .key('H', metaitem('hull.mv'))
    .key('M', ore('circuitHv'))
    .key('F', metaitem('field.generator.mv'))
    .register()

/*hv assembler, buffed and moved to ass
crafting.remove('gregtech:gregtech.machine.assembler.hv')
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem(''), metaitem('') * 2, metaitem(''))
    .fluidInputs(fluid('') * 144)
    .outputs(metaitem(''))
    .duration(200).EUt(30)
    .buildAndRegister()
*/

//stainless steel changes
mods.gregtech.electric_blast_furnace.removeByOutput([metaitem('ingotStainlessSteel')], null)
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustStainlessSteel'))
    .circuitMeta(1)
    .outputs(metaitem('ingotStainlessSteel'))
    .duration(9000).EUt(480)
    .property('temperature', 1700)
    .buildAndRegister()

mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustStainlessSteel'))
    .circuitMeta(2)
    .fluidInputs(fluid('helium') * 500)
    .outputs(metaitem('ingotStainlessSteel'))
    .duration(1600).EUt(1920)
    .property('temperature', 1700)
    .buildAndRegister()

//kanthal changes
mods.gregtech.electric_blast_furnace.removeByOutput([metaitem('ingotHotKanthal')], null)
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustKanthal'))
    .circuitMeta(1)
    .outputs(metaitem('ingotHotKanthal'))
    .duration(3600).EUt(480)
    .property('temperature', 1800)
    .buildAndRegister()

mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustKanthal'))
    .circuitMeta(2)
    .fluidInputs(fluid('nitrogen') * 1000)
    .outputs(metaitem('ingotHotKanthal'))
    .duration(2412).EUt(480)
    .property('temperature', 1800)
    .buildAndRegister()

//advanced inscriber changes
crafting.remove('ae2stuff:recipe1')
crafting.shapedBuilder()
    .output(item('ae2stuff:inscriber'))
    .matrix(
        'PCP',
        'EIE',
        'PCP')
    .key('P', metaitem('plateStainlessSteel'))
    .key('C', metaitem('conveyor.module.hv'))
    .key('E', item('appliedenergistics2:material:24'))
    .key('I', item('appliedenergistics2:inscriber'))
    .register()

//pcc changes
crafting.remove('nae2:item/upgrade/gregtech_circuit')
mods.gregtech.assembler.recipeBuilder()
    .inputs(item('appliedenergistics2:material:53'), ore('circuitEv') * 2,
        metaitem('circuit.integrated').withNbt(['Configuration' : 0]) * 16)
    .fluidInputs(fluid('plastic') * 576)
    .outputs(item('nae2:upgrade:2'))
    .duration(300).EUt(480)
    .buildAndRegister()

//mm stuff changes
//basic mining laser
crafting.shapedBuilder()
    .output(item('nomilabs:t1laser'))
    .matrix(
        ' F ',
        'PBP',
        'PCP')
    .key('F', ore('blockCrystalFlux'))
    .key('P', metaitem('plateDoubleSteel'))
    .key('B', metaitem('energy_crystal').withNbt(['Charge' : 6400000]))
    .key('C', ore('circuitHv'))
    .register()

//water -> liquid ice for silicon and kanthal in chembath
for (var kanthalSilicon: ['Kanthal', 'Silicon']) {
    mods.gregtech.chemical_bath.removeByOutput([metaitem("ingot${kanthalSilicon}")], null)
    mods.gregtech.chemical_bath.recipeBuilder()
        .inputs(metaitem("ingotHot${kanthalSilicon}"))
        .fluidInputs(fluid('ice') * 300)
        .outputs(metaitem("ingot${kanthalSilicon}"))
        .duration(800).EUt(120)
        .buildAndRegister()
}

//pvc plastic board nerfed to return only 1, 4 -> 8 copper foils, duration 25s -> 30s (now matches 1:1 ratio)
mods.gregtech.chemical_reactor.removeByInput(10,
    [metaitem('platePolyvinylChloride'),
     metaitem('foilCopper') * 4],
    [fluid('sulfuric_acid') * 250])
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(metaitem('platePolyvinylChloride'), metaitem('foilCopper') * 8)
    .fluidInputs(fluid('sulfuric_acid') * 250)
    .outputs(metaitem('board.plastic'))
    .duration(600).EUt(10)
    .buildAndRegister()

//distillation tower buffed and moved to ass
crafting.remove('gregtech:distillation_tower')
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('distillery.hv'),
        item('gregtech:wire_coil:2') * 4,
        metaitem('pipeHugeFluidStainlessSteel') * 6,
        metaitem('electric.pump.hv') * 8,
        ore('circuitEv') * 12)
    .fluidInputs(fluid('lubricant') * 16000)
    .outputs(metaitem('distillation_tower'))
    .duration(1200).EUt(480)
    .buildAndRegister()

//titanium loop no longer closed, 2 -> 4 magnesium :problem:, also buffed duration for ebf
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustMagnesium') * 2],
    [fluid('titanium_tetrachloride') * 1000 * 1000])
mods.gregtech.electric_blast_furnace.recipeBuilder()
    .inputs(metaitem('dustMagnesium') * 4)
    .fluidInputs(fluid('titanium_tetrachloride') * 1100)
    .outputs(metaitem('ingotHotTitanium'), metaitem('dustMagnesiumChloride') * 6)
    .duration(4000).EUt(480)
    .property('temperature', 2141)
    .buildAndRegister()

//NaK "realism"
mods.gregtech.chemical_reactor.removeByOutput(null, [fluid('sodium_potassium')])
mods.gregtech.chemical_reactor.recipeBuilder()
    .inputs(metaitem('dustPotassium') * 4, metaitem('dustSodium'))
    .fluidOutputs(fluid('sodium_potassium') * 720)
    .duration(800).EUt(30)
    .buildAndRegister()

//me out hatch
mods.gregtech.assembler.removeByOutput([metaitem('me_export_fluid_hatch')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('fluid_hatch.export.ev'), item('appliedenergistics2:drive'),
        metaitem('super_tank.ev') * 10, item('appliedenergistics2:part:221') * 4)
    .outputs(metaitem('me_export_fluid_hatch'))
    .duration(400).EUt(480)
    .buildAndRegister()

//me in hatch
mods.gregtech.assembler.removeByOutput([metaitem('me_import_fluid_hatch')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('fluid_hatch.import.ev'), item('appliedenergistics2:fluid_interface') * 4,
        metaitem('electric.pump.ev') * 4)
    .outputs(metaitem('me_import_fluid_hatch'))
    .duration(400).EUt(480)
    .buildAndRegister()

//me out bus
mods.gregtech.assembler.removeByOutput([metaitem('me_export_item_bus')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('item_bus.export.ev'), item('appliedenergistics2:drive'),
        metaitem('super_chest.ev') * 10, item('appliedenergistics2:part:220') * 4)
    .outputs(metaitem('me_export_item_bus'))
    .duration(400).EUt(480)
    .buildAndRegister()

//me in bus
mods.gregtech.assembler.removeByOutput([metaitem('me_import_item_bus')], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('item_bus.import.ev'), item('appliedenergistics2:interface') * 4,
        metaitem('conveyor.module.ev') * 4)
    .outputs(metaitem('me_import_item_bus'))
    .duration(400).EUt(480)
    .buildAndRegister()

//stocking bus and hatch
for (var stockingType: ['fluid_hatch', 'item_bus']) {
mods.gregtech.assembler.removeByOutput([metaitem("me_stocking_${stockingType}")], null)
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem("${stockingType}.import.iv"), metaitem("me_import_${stockingType}"),
        item('nae2:exposer') * 4, item('appliedenergistics2:io_port') * 4,
        metaitem('field.generator.iv') * 4, item('appliedenergistics2:material', 30) * 16)
    .fluidInputs(fluid('nether_star') * 2592)
    .outputs(metaitem("me_stocking_${stockingType}"))
    .duration(800).EUt(7920)
    .buildAndRegister()
}

//lcr, buffed and moved to ass
crafting.remove('gregtech:large_chemical_reactor')
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('chemical_reactor.hv') * 4, metaitem('fluid.regulator.hv') * 2,
        metaitem('pipeNonupleFluidPolytetrafluoroethylene') * 4,
        item('gregtech:meta_item_1', 711).withNbt(['GT.PartStats': ['Material': 'gregtech:stainless_steel']]),
        ore('circuitEv') * 4)
    .outputs(metaitem('large_chemical_reactor'))
    .duration(700).EUt(480)
    .buildAndRegister()


