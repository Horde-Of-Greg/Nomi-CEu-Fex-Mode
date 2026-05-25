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

